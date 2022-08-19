export const themeData = JSON.parse("{\"locales\":{\"/en/\":{\"selectText\":\"Language\",\"label\":\"English\",\"sidebar\":[\"/en/\",\"/en/presentation/\",\"/en/tooling/\",\"/en/kotlin/\",\"/en/kotlin-and-java/\",\"/en/advanced-kotlin/\",\"/en/backend-development/\",\"/en/mobile-development/\",\"/en/multiplatform/\",\"/en/to-go-futher/\"]},\"/fr/\":{\"selectText\":\"Langue\",\"label\":\"Français\",\"sidebar\":[\"/fr/\"]},\"/\":{\"selectLanguageName\":\"English\"}},\"colorMode\":\"auto\",\"colorModeSwitch\":true,\"navbar\":[],\"logo\":null,\"repo\":null,\"selectLanguageText\":\"Languages\",\"selectLanguageAriaLabel\":\"Select language\",\"sidebar\":\"auto\",\"sidebarDepth\":2,\"editLink\":true,\"editLinkText\":\"Edit this page\",\"lastUpdated\":true,\"lastUpdatedText\":\"Last Updated\",\"contributors\":true,\"contributorsText\":\"Contributors\",\"notFound\":[\"There's nothing here.\",\"How did we get here?\",\"That's a Four-Oh-Four.\",\"Looks like we've got some broken links.\"],\"backToHome\":\"Take me home\",\"openInNewWindow\":\"open in new window\",\"toggleColorMode\":\"toggle color mode\",\"toggleSidebar\":\"toggle sidebar\"}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updateThemeData) {
    __VUE_HMR_RUNTIME__.updateThemeData(themeData)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ themeData }) => {
    __VUE_HMR_RUNTIME__.updateThemeData(themeData)
  })
}
