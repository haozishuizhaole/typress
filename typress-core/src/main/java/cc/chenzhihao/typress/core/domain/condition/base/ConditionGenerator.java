package cc.chenzhihao.typress.core.domain.condition.base;

import cc.chenzhihao.typress.core.domain.model.entity.Article;
import cc.chenzhihao.typress.core.domain.model.entity.Config;
import cc.chenzhihao.typress.core.domain.model.entity.Session;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 查询条件生成器
 *
 * @author chenzhihao
 * @date 2023-09-14 20:27
 */
public class ConditionGenerator {

    private final String backDir;
    private final String packageName;
    private final List<Class<?>> classes;

    private ConditionGenerator(String backDir, String packageName, List<Class<?>> classes) {
        this.backDir = backDir;
        this.packageName = packageName;
        this.classes = classes;
    }

    public static ConditionGenerator of(String backDir, String packageName, List<Class<?>> classes) {
        return new ConditionGenerator(backDir, packageName, classes);
    }

    public static void main(String[] args) {
        String packageName = "cc.chenzhihao.typress.core.domain.condition";
        ConditionGenerator.of("src/main/java", packageName, Collections.singletonList(Config.class)).generate();
        ConditionGenerator.of("src/main/java", packageName, Collections.singletonList(Article.class)).generate();
        ConditionGenerator.of("src/main/java", packageName, Collections.singletonList(Session.class)).generate();
    }

    public void generate() {
        for (Class<?> cls : this.classes) {
            String generateClassName = cls.getSimpleName() + "Condition";
            String generateClassFileName = generateClassName + ".java";
            String classFileContent = new Generator(cls, packageName, generateClassName).generate();
            try {
                String path = getGenerateFilePath() + generateClassFileName;
                System.out.println(path);
                FileUtils.writeStringToFile(new File(path), classFileContent, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getGenerateFilePath() {
        String projectPath = this.getClass().getClassLoader().getResource("").getPath().replace("target" + File.separator + "classes" + File.separator, "");
        String classFileName = packageName.replace(".", File.separator) + File.separator;
        return projectPath + backDir + File.separator + classFileName;
    }

    protected static class Generator {
        private final Map<String, Field> fields;
        private final Set<Class<?>> importClasses;
        private final String generateClassPackageName;
        private final String generateClassName;

        public Generator(Class<?> cls, String generateClassPackageName, String generateClassName) {
            this.fields = new LinkedHashMap<>();
            this.importClasses = new LinkedHashSet<>();
            this.generateClassPackageName = generateClassPackageName;
            this.generateClassName = generateClassName;
            parse(cls);
        }

        private void parse(Class<?> cls) {
            generateImportClasses();
            getFields(cls);
        }

        private void generateImportClasses() {
            importClasses.add(Condition.class);
            importClasses.add(List.class);
            importClasses.add(ArrayList.class);
        }

        private void getFields(Class<?> cls) {
            for (Field field : cls.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                fields.put(field.getName(), field);
                Class<?> fieldType = field.getType();
                if (!fieldType.getPackage().getName().startsWith("java.lang")) {
                    importClasses.add(fieldType);
                }
            }
            Class<?> superclass = cls.getSuperclass();
            if (superclass == null || superclass == Object.class) {
                return;
            }
            getFields(superclass);
        }

        public String generate() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("package %s;\n\n", generateClassPackageName));
            for (Class<?> importClass : this.importClasses) {
                sb.append(String.format("import %s;\n", importClass.getName()));
            }
            sb.append("\n");
            sb.append(String.format("public class %s extends Condition {\n", generateClassName));
            sb.append("\tprivate final List<Criteria> oredCriteria;\n\n");
            sb.append(String.format("\tpublic %s() {\n" +
                    "\t\toredCriteria = new ArrayList<>();\n" +
                    "\t}\n" +
                    "\n" +
                    "\tpublic Criteria createCriteria() {\n" +
                    "\t\tCriteria criteria = new Criteria();\n" +
                    "\t\toredCriteria.add(criteria);\n" +
                    " \t\treturn criteria;\n" +
                    "\t}\n" +
                    "\n" +
                    "\tpublic List<Criteria> getOredCriteria() {\n" +
                    "\t\treturn oredCriteria;\n" +
                    "\t}\n", generateClassName));
            sb.append("\n");

            sb.append("\tpublic static class Criteria {\n");

            StringBuilder conditionAccessorFunctionsSb = new StringBuilder();
            this.fields.forEach((fieldName, field) -> {
                String fistUpperCaseFiledName = StringUtils.capitalize(fieldName);
                Class<?> fieldType = field.getType();
                String fieldTypeName = fieldType.getSimpleName();
                sb.append(String.format("\t\tprivate Boolean %sIsNull;\n", fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic Boolean get%sIsNull() {\n" +
                        "\t\t\treturn %sIsNull;\n" +
                        "\t\t}\n\n", fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sIsNull() {\n" +
                        "\t\t\tthis.%sIsNull = Boolean.TRUE;\n" +
                        "\t\t}\n\n", fieldName, fieldName));
                sb.append(String.format("\t\tprivate Boolean %sIsNotNull;\n", fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic Boolean get%sIsNotNull() {\n" +
                        "\t\t\treturn %sIsNotNull;\n" +
                        "\t\t}\n\n", fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sIsNotNull() {\n" +
                        "\t\t\tthis.%sIsNotNull = Boolean.TRUE;\n" +
                        "\t\t}\n\n", fieldName, fieldName));
                sb.append(String.format("\t\tprivate %s %sEqualTo;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sEqualTo() {\n" +
                        "\t\t\treturn %sEqualTo;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sEqualTo(%s value) {\n" +
                        "\t\t\tthis.%sEqualTo = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s %sNotEqualTo;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sNotEqualTo() {\n" +
                        "\t\t\treturn %sNotEqualTo;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sNotEqualTo(%s value) {\n" +
                        "\t\t\tthis.%sNotEqualTo = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s %sGreaterThan;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sGreaterThan() {\n" +
                        "\t\t\treturn %sGreaterThan;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sGreaterThan(%s value) {\n" +
                        "\t\t\tthis.%sGreaterThan = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s %sGreaterThanOrEqualTo;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sGreaterThanOrEqualTo() {\n" +
                        "\t\t\treturn %sGreaterThanOrEqualTo;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sGreaterThanOrEqualTo(%s value) {\n" +
                        "\t\t\tthis.%sGreaterThanOrEqualTo = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s %sLessThan;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sLessThan() {\n" +
                        "\t\t\treturn %sLessThan;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sLessThan(%s value) {\n" +
                        "\t\t\tthis.%sLessThan = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s %sLessThanOrEqualTo;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s get%sLessThanOrEqualTo() {\n" +
                        "\t\t\treturn %sLessThanOrEqualTo;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sLessThanOrEqualTo(%s value) {\n" +
                        "\t\t\tthis.%sLessThanOrEqualTo = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate List<%s> %sIn;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic List<%s> get%sIn() {\n" +
                        "\t\t\treturn %sIn;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sIn(List<%s> value) {\n" +
                        "\t\t\tthis.%sIn = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate List<%s> %sNotIn;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic List<%s> get%sNotIn() {\n" +
                        "\t\t\treturn %sNotIn;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sNotIn(List<%s> value) {\n" +
                        "\t\t\tthis.%sNotIn = value;\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldName));
                sb.append(String.format("\t\tprivate %s[] %sBetween;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s[] get%sBetween() {\n" +
                        "\t\t\treturn %sBetween;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sBetween(%s beginValue, %s endValue) {\n" +
                        "\t\t\tthis.%sBetween = new %s[]{beginValue, endValue};\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldTypeName, fieldName, fieldTypeName));
                sb.append(String.format("\t\tprivate %s[] %sNotBetween;\n", fieldTypeName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic %s[] get%sNotBetween() {\n" +
                        "\t\t\treturn %sNotBetween;\n" +
                        "\t\t}\n\n", fieldTypeName, fistUpperCaseFiledName, fieldName));
                conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sNotBetween(%s beginValue, %s endValue) {\n" +
                        "\t\t\tthis.%sNotBetween = new %s[]{beginValue, endValue};\n" +
                        "\t\t}\n\n", fieldName, fieldTypeName, fieldTypeName, fieldName, fieldTypeName));
                if (fieldType.equals(String.class)) {
                    sb.append(String.format("\t\tprivate String %sLike;\n", fieldName));
                    conditionAccessorFunctionsSb.append(String.format("\t\tpublic String get%sLike() {\n" +
                            "\t\t\treturn %sLike;\n" +
                            "\t\t}\n\n", fistUpperCaseFiledName, fieldName));
                    conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sLike(String value) {\n" +
                            "\t\t\tthis.%sLike = value;\n" +
                            "\t\t}\n\n", fieldName, fieldName));
                    sb.append(String.format("\t\tprivate String %sNotLike;\n", fieldName));
                    conditionAccessorFunctionsSb.append(String.format("\t\tpublic String get%sNotLike() {\n" +
                            "\t\t\treturn %sNotLike;\n" +
                            "\t\t}\n\n", fistUpperCaseFiledName, fieldName));
                    conditionAccessorFunctionsSb.append(String.format("\t\tpublic void %sNotLike(String value) {\n" +
                            "\t\t\tthis.%sNotLike = value;\n" +
                            "\t\t}\n\n", fieldName, fieldName));
                }
                sb.append("\n");

            });

            sb.append(conditionAccessorFunctionsSb);
            sb.append("\t}\n");

            sb.append("}\n");

            return sb.toString();
        }
    }
}
