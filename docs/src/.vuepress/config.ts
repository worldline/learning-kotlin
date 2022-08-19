import { defaultTheme } from "@vuepress/theme-default";
import { searchPlugin } from "@vuepress/plugin-search";
import { nprogressPlugin } from "@vuepress/plugin-nprogress";
import { pwaPlugin } from "@vuepress/plugin-pwa";

module.exports = {
  base: "/learning-kotlin/",
  locales: {
    "/en/": {
      lang: "en-US", // this will be set as the lang attribute on <html>
      title: "Learning Kotlin",
      description: "Learning Kotlin",
    },

    "/fr/": {
      lang: "fr-FR",
      title: "Apprendre Kotlin",
      description: "Une formation d'introduction à Kotlin",
    },
  },
  head: [
    ["link", { rel: "icon", href: "/learning-kotlin/favicon.ico" }],
    [
      "link",
      { rel: "manifest", href: "/learning-kotlin/manifest.webmanifest" },
    ],
    ["meta", { name: "theme-color", content: "#2176d6" }],
  ],

  theme: defaultTheme({
    locales: {
      "/en/": {
        selectText: "Language",
        label: "English",
        sidebar: [
          "/en/",
          "/en/presentation/",
          "/en/tooling/",
          "/en/kotlin/",
          "/en/kotlin-and-java/",
          "/en/advanced-kotlin/",
          "/en/backend-development/",
          "/en/mobile-development/",
          "/en/multiplatform/",
          "/en/to-go-futher/",
        ],
      },

      "/fr/": {
        selectText: "Langue",
        label: "Français",
        sidebar: ["/fr/"],
      },
    },
  }),

  plugins: [
    searchPlugin({
      locales: {
        "/": {
          placeholder: "Search",
        },
        "/fr/": {
          placeholder: "Rechercher",
        },
      },
    }),
    nprogressPlugin(),
    pwaPlugin({}),
  ],
};
