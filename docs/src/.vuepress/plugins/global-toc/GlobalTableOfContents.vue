<template>
<ul>
    <li v-for="item in items">
        <router-link :to="item.path">{{item.title || item.path}}</router-link>
        <ul v-if="item.headers">
            <li v-for="header in item.headers">
                <router-link :to="item.path + '#' + header.slug">{{header.title}}</router-link>
            </li>
        </ul>
    </li>
</ul>
</template>

<script>
import { resolveSidebarItems } from '@vuepress/theme-default/util/'

export default {
    name: "GlobalTableOfContents",
    computed:{
        items(){
            return resolveSidebarItems(
                this.$page,
                this.$page.regularPath,
                this.$site,
                this.$localePath
            )
        }
    }
}
</script>