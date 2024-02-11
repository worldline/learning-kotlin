import { pwaPlugin } from "@vuepress/plugin-pwa";
import { searchPlugin } from "@vuepress/plugin-search";
import { defineUserConfig } from "vuepress";
import { defaultTheme } from "@vuepress/theme-default";
import { mediumZoomPlugin } from "@vuepress/plugin-medium-zoom";
import { mdEnhancePlugin } from "vuepress-plugin-md-enhance";
import { pwaPopupPlugin } from "@vuepress/plugin-pwa-popup";
import { viteBundler } from "@vuepress/bundler-vite";

export default defineUserConfig({
  bundler: viteBundler({
    viteOptions: {},
    vuePluginOptions: {},
  }),
  base: "/learning-kotlin/",
  port: 3001,
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
    logo: "logo_worldline.png",
    repo: "worldline/learning-kotlin",
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
          "/en/workshops/",
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
          "/fr/workshops/",
        ],
      },
    },
  }),

  plugins: [
    searchPlugin({
      locales: {
        "/en/": {
          placeholder: "Search",
        },
        "/fr/": {
          placeholder: "Rechercher",
        },
      },
    }),
    pwaPlugin({}),
    mediumZoomPlugin({}),
    pwaPopupPlugin({
      locales: {
        "/en/": {
          message: "New content is available.",
          buttonText: "Refresh",
        },
        "/fr/": {
          message: "Du nouveau contenu est disponible.",
          buttonText: "Actualiser",
        },
      },
    }),
    mdEnhancePlugin({
      imgLazyload: true,
      imgSize: true,
      figure: true,
      imgMark: true,
    }),
    // nprogressPlugin(),
    // seoPlugin({
    //   hostname: "https://worldline.github.io/learning-kotlin",
    // }),
  ],
});
