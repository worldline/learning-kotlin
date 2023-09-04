package com.devoxxfr2023.km

import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    PreComposeApplication("QuizApp") {
        App()
    }