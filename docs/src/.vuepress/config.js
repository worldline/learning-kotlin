module.exports = {
	base: "/learning-kotlin/",
	locales: {
		"/": {
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

	themeConfig: {
		nav: [
      { text: 'GitHub', link: 'https://github.com/worldline/learning-kotlin' }
    ],
		locales: {
			"/": {
				selectText: "Language",
				label: "English",
				sidebar: [
					"/",
          "/presentation/",
          "/tooling/",
          "/kotlin/",
          "/kotlin-and-java/",
          "/advanced-kotlin/",
          "/backend-development/",
          "/mobile-development/",
          "/multiplatform/",
          "/to-go-futher/",
				],
			},

			"/fr/": {
				selectText: "Langue",
				label: "Français",
				sidebar: [
					"/fr/",
				],
			},
		},
	},

	plugins: [
		require("./plugins/copy-code/"),
		"vuepress-plugin-global-toc",
		["live"],
	],
}