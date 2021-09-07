import java.util.Random
fun main(){
    val random=Random()
    var answer= arrayListOf<Int>()
    val user= arrayListOf<Int>()
    var count=0
    var userCollect= arrayListOf<Int>()
    var resultCollect= arrayListOf<String>()

    while(answer.size != 3){
        val rand = random.nextInt(10)

        if(!(rand in answer)){
            answer.add(rand)
        }
    }

    while(true) {
        user.clear()
        println("숫자를 입력하세요")
        var choose = readLine()
        if (choose == "R") {
            var num=0
            for (i in 0..(userCollect.size-1)) {
                print("${userCollect[i]} ")
                num++
                if (num % 3 == 0)
                    println("")
            }
            for(i in 0..resultCollect.size-1){
                if(resultCollect[i]!="end")
                    print("${resultCollect[i]} ")
                else
                    print("|")
            }
            println("${count}회 시도")
        } else {
            count++
            user.add(choose!!.toInt())
            for (i in 1..2) user.add(readLine()!!.toInt())
            var strike = 0
            var ball = 0

            for (i in 0..2) {
                if (answer[i] == user[i])
                    strike++
            }

            for (i in 0..2) {
                for (j in 0..2) {
                    if (i != j) {
                        if (answer[i] == user[j]) ball++
                    }
                }
            }
            if (ball > 0) {
                println("${ball}B")
                resultCollect.add("${ball}B")
            }
            if (strike > 0) {
                println("${strike}S")
                resultCollect.add("${strike}S")
            }
            if (ball == 0 && strike == 0){
                println("일치하는 값이 없습니다.")
                resultCollect.add("일치하는 값이 없습니다.")
            }
            resultCollect.add("end")

            if (strike == 3)
                break

            for (i in 0..2) {
                userCollect.add(user[i])
            }
        }
    }
    println("$count 회 만에 성공\n축하합니다")
}