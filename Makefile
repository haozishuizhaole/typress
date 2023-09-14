.DEFAULT: all

all: build

# 编译服务端
build: clean
	mvn compile

# 清除服务端编译或打包产物
clean:
	mvn clean

# 打包服务端(跳过测试)
package: clean
	mvn package -DskipTests=true

# 执行服务端单元测试
test:
	mvn test

# 执行 Mybatis Generator
mbg: mbg-sqlite

mbg-sqlite:
	mvn mybatis-generator:generate -Dmybatis.generator.contexts=sqlite -pl=typress-core

mbg-mysql:
	mvn mybatis-generator:generate -Dmybatis.generator.contexts=mysql -pl=typress-core

# 运行服务端
run:
	mvn spring-boot:run -pl typress-server