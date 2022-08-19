export const data = JSON.parse("{\"key\":\"v-8daa1a0e\",\"path\":\"/\",\"title\":\"Welcome\",\"lang\":\"en-US\",\"frontmatter\":{\"home\":true,\"heroImage\":\"./kotlin_logo.png\",\"tagline\":\"A beginner's guide to a modern programming language\",\"actions\":[{\"text\":\"Get started →\",\"link\":\"/en/presentation/\",\"type\":\"primary\"}],\"features\":[{\"title\":\"Start with Kotlin\",\"details\":\"lorem\"},{\"title\":\"Basic syntax\",\"details\":\"lorem\"},{\"title\":\"Exemple\",\"details\":\"lorem\"}],\"footer\":\"Worldline, 2021\"},\"excerpt\":\"\",\"headers\":[{\"level\":2,\"title\":\"Prerequisites\",\"slug\":\"prerequisites\",\"children\":[]},{\"level\":2,\"title\":\"Useful links\",\"slug\":\"useful-links\",\"children\":[]}],\"git\":{\"updatedTime\":1636726213000,\"contributors\":[{\"name\":\"W112314\",\"email\":\"quentin.carpentier@worldline.com\",\"commits\":2}]},\"filePathRelative\":\"index.md\"}")

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updatePageData) {
    __VUE_HMR_RUNTIME__.updatePageData(data)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ data }) => {
    __VUE_HMR_RUNTIME__.updatePageData(data)
  })
}
