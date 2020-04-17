/*
    Create a program that receive many arrays and creates a new array with elements that are present in at
    least two array.

    Complexity:
    Time: O(N) -> where N is the size of the biggest array
    Space: O(N)
 */
fun main(args: Array<String>) {

    val arrayA = arrayOf<Int>(2, 5, 3, 2, 8, 1)
    val arrayB = arrayOf<Int>(7, 9, 5, 2, 4, 10, 10)
    val arrayC = arrayOf<Int>(6, 7, 5, 5, 3, 7)

    val allArrays = arrayOf(arrayA,arrayB,arrayC)

    val arrayDuplicateds = findDuplications(allArrays)

    println("ArrayOfDuplicated: ")
    print("[")
    for(position in 0 until arrayDuplicateds.size){
        print(arrayDuplicateds[position])
        if(position != arrayDuplicateds.size - 1)
        {
            print(",")
        }
    }
    print("]")
}

fun findDuplications(allArrays: Array<Array<Int>>) : Array<Int> {
    var listOfDuplicateds = mutableListOf<Int>()

    var biggestArraySize = 0;

    allArrays.forEach {
        if(it.size > biggestArraySize){
            biggestArraySize = it.size
        }
    }

    var map = hashMapOf<Int,Int>()

    for (position in 0 until biggestArraySize){
        allArrays.forEachIndexed(){index, array->
            if(position < array.size) {
                val currentValue = array[position]

                if (map.containsKey(currentValue) && map[currentValue] != index) {
                    listOfDuplicateds.add(currentValue)
                }

                map[currentValue] = index
            }

        }
    }

    return listOfDuplicateds.toTypedArray()

}