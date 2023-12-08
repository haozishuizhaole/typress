<template>
    <div class="common-layout">
        <el-container>
            <el-header style="backgroundColor:red;">Header</el-header>
            <el-container>
                <el-aside width="200px" style="backgroundColor:blue;">
                    <el-scrollbar>
                        <!--<el-menu>-->
                        <!--    <el-sub-menu index="1">-->
                        <!--        <template #title>-->
                        <!--            <el-icon>-->
                        <!--                <i-ep-message/>-->
                        <!--            </el-icon>-->
                        <!--            Navigator One-->
                        <!--        </template>-->
                        <!--        <el-menu-item-group>-->
                        <!--            <template #title>Group 1</template>-->
                        <!--            <el-menu-item index="1-1">Option 1</el-menu-item>-->
                        <!--            <el-menu-item index="1-2">Option 2</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-menu-item-group title="Group 2">-->
                        <!--            <el-menu-item index="1-3">Option 3</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-sub-menu index="1-4">-->
                        <!--            <template #title>Option4</template>-->
                        <!--            <el-menu-item index="1-4-1">Option 4-1</el-menu-item>-->
                        <!--        </el-sub-menu>-->
                        <!--    </el-sub-menu>-->
                        <!--    <el-sub-menu index="2">-->
                        <!--        <template #title>-->
                        <!--            <el-icon>-->
                        <!--                <i-ep-menu/>-->
                        <!--            </el-icon>-->
                        <!--            Navigator Two-->
                        <!--        </template>-->
                        <!--        <el-menu-item-group>-->
                        <!--            <template #title>Group 1</template>-->
                        <!--            <el-menu-item index="2-1">Option 1</el-menu-item>-->
                        <!--            <el-menu-item index="2-2">Option 2</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-menu-item-group title="Group 2">-->
                        <!--            <el-menu-item index="2-3">Option 3</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-sub-menu index="2-4">-->
                        <!--            <template #title>Option 4</template>-->
                        <!--            <el-menu-item index="2-4-1">Option 4-1</el-menu-item>-->
                        <!--        </el-sub-menu>-->
                        <!--    </el-sub-menu>-->
                        <!--    <el-sub-menu index="3">-->
                        <!--        <template #title>-->
                        <!--            <el-icon>-->
                        <!--                <i-ep-setting/>-->
                        <!--            </el-icon>-->
                        <!--            Navigator Three-->
                        <!--        </template>-->
                        <!--        <el-menu-item-group>-->
                        <!--            <template #title>Group 1</template>-->
                        <!--            <el-menu-item index="3-1">Option 1</el-menu-item>-->
                        <!--            <el-menu-item index="3-2">Option 2</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-menu-item-group title="Group 2">-->
                        <!--            <el-menu-item index="3-3">Option 3</el-menu-item>-->
                        <!--        </el-menu-item-group>-->
                        <!--        <el-sub-menu index="3-4">-->
                        <!--            <template #title>Option 4</template>-->
                        <!--            <el-menu-item index="3-4-1">Option 4-1</el-menu-item>-->
                        <!--        </el-sub-menu>-->
                        <!--    </el-sub-menu>-->
                        <!--</el-menu>-->
                        <el-menu
                            active-text-color="#ffd04b"
                            background-color="#545c64"
                            class="el-menu-vertical-demo"
                            default-active="2"
                            text-color="#fff"
                            @open="handleOpen"
                            @close="handleClose"
                        >
                            <!--<el-sub-menu index="1">-->
                            <!--    <template #title>-->
                            <!--        <el-icon>-->
                            <!--            <i-ep-location/>-->
                            <!--        </el-icon>-->
                            <!--        <span>Navigator One</span>-->
                            <!--    </template>-->
                            <!--    <el-menu-item-group title="Group One">-->
                            <!--        <el-menu-item index="1-1">item one</el-menu-item>-->
                            <!--        <el-menu-item index="1-2">item two</el-menu-item>-->
                            <!--    </el-menu-item-group>-->
                            <!--    <el-menu-item-group title="Group Two">-->
                            <!--        <el-menu-item index="1-3">item three</el-menu-item>-->
                            <!--    </el-menu-item-group>-->
                            <!--    <el-sub-menu index="1-4">-->
                            <!--        <template #title>item four</template>-->
                            <!--        <el-menu-item index="1-4-1">item one</el-menu-item>-->
                            <!--    </el-sub-menu>-->
                            <!--</el-sub-menu>-->
                            <el-menu-item index="1">
                                <el-icon>
                                    <icon-menu/>
                                </el-icon>
                                <span>
                                     <router-link to="/admin">
                                    Navigator Two
                                     </router-link>
                                </span>
                            </el-menu-item>
                            <el-menu-item index="3" disabled>
                                <el-icon>
                                    <document/>
                                </el-icon>
                                <span>Navigator Three</span>
                            </el-menu-item>
                            <el-menu-item index="4">
                                <el-icon>
                                    <setting/>
                                </el-icon>
                                <span>Navigator Four</span>
                            </el-menu-item>
                        </el-menu>
                    </el-scrollbar>
                </el-aside>
                <el-container>
                    <el-main style="backgroundColor:#63ba94;">
                        Main
                        <br>
                        <router-view></router-view>
                    </el-main>
                    <el-footer style="backgroundColor:#6f6732;">Footer</el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
// import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
export default {
    name: "AdminLayout"
}
</script>

<style scoped>
.layout-container-demo .el-header {
    position: relative;
    background-color: var(--el-color-primary-light-7);
    color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
    color: var(--el-text-color-primary);
    background: var(--el-color-primary-light-8);
}

.layout-container-demo .el-menu {
    border-right: none;
}

.layout-container-demo .el-main {
    padding: 0;
}

.layout-container-demo .toolbar {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    right: 20px;
}
</style>
