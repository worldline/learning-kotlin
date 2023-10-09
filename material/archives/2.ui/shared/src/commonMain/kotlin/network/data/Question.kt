package network.data

data class Question(val id:Int, val label:String, val correctAnswerId:Int, val answers:List<Answer>)