export const siteData = JSON.parse("{\"base\":\"/learning-kotlin/\",\"lang\":\"en-US\",\"title\":\"\",\"description\":\"\",\"head\":[[\"link\",{\"rel\":\"icon\",\"href\":\"/learning-kotlin/favicon.ico\"}],[\"link\",{\"rel\":\"manifest\",\"href\":\"/learning-kotlin/manifest.webmanifest\"}],[\"meta\",{\"name\":\"theme-color\",\"content\":\"#2176d6\"}]],\"locales\":{\"/en/\":{\"lang\":\"en-US\",\"title\":\"Learning Kotlin\",\"description\":\"Learning Kotlin\"},\"/fr/\":{\"lang\":\"fr-FR\",\"title\":\"Apprendre Kotlin\",\"description\":\"Une formation d'introduction à Kotlin\"}}}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updateSiteData) {
    __VUE_HMR_RUNTIME__.updateSiteData(siteData)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ siteData }) => {
    __VUE_HMR_RUNTIME__.updateSiteData(siteData)
  })
}
