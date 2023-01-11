import { defaultTheme } from "@vuepress/theme-default";
import { searchPlugin } from "@vuepress/plugin-search";
import { nprogressPlugin } from "@vuepress/plugin-nprogress";
import { pwaPlugin } from "@vuepress/plugin-pwa";
import { seoPlugin } from "vuepress-plugin-seo2";
import { defineUserConfig } from "vuepress";

export default defineUserConfig({
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
        selectLanguageName: "English",
        sidebar: [
          "/en/presentation/",
          "/en/kotlin-features/",
          "/en/backend-development/",
          "/en/front-development/",
          "/en/other-technologies/",
          "/en/kotlin-features-advanced/",
          "/en/to-go-futher/",
        ],
      },

      "/fr/": {
        selectLanguageName: "Français",
        sidebar: [
          "/fr/presentation/",
          "/fr/kotlin-features/",
          "/fr/backend-development/",
          "/fr/front-development/",
          "/fr/other-technologies/",
          "/fr/kotlin-features-advanced/",
          "/fr/to-go-futher/",
        ],
      },
    },
  }),

  plugins: [
    // searchPlugin({
    //   locales: {
    //     "/en/": {
    //       placeholder: "Search",
    //     },
    //     "/fr/": {
    //       placeholder: "Rechercher",
    //     },
    //   },
    // }),
    // nprogressPlugin(),
    // pwaPlugin({}),
    seoPlugin({
      hostname: "https://worldline.github.io/learning-kotlin",
    }),
  ],
});
