import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import network.QuizRepository

private val quizRepository = QuizRepository()

@Composable
internal fun rootNavHost() {

    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/welcome",
    ) {
        scene(
            route = "/welcome",
            navTransition = NavTransition(),
        ) {
            welcomeScreen(navigator)
        }
        scene(
            route = "/quiz",
            navTransition = NavTransition(),
        ) {

            val questions = quizRepository.questionState.collectAsState()

            if (questions.value.isNotEmpty()) {
                questionScreen(navigator, questions.value)
            }
        }
        scene(
            route = "/score/{score}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<String>("score")?.let { score ->
                scoreScreen(navigator, score)
            }
        }
    }
}