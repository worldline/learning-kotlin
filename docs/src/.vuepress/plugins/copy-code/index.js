const { path } = require('@vuepress/shared-utils')

module.exports = (options) => ({
    define: {
      COPY_SELECTOR: options.copy_selector || 'div[class*="language-"] pre'
    },
    clientRootMixin: path.resolve(__dirname, 'clientRootMixin.js')
})