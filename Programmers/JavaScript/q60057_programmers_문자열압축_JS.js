function solution(s) {
    const strArr = [...s]
    //const strArr = Array.from(s)
    //const strArr = s.split('')

    let answer = strArr.length;

    //console.log(strArr)

    for (var i = 1; i <= strArr.length / 2; i++) {
        var count = i;
        var idx = 0;
        var now = i;
        var duple = 0;
        for (; now < strArr.length - (strArr.length % i); now += i) {
            var flag = true;
            for (var j = 0; j < i; j++) {
                if (strArr[idx + j] !== strArr[now + j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                duple = (duple === 0) ? 2 : ++duple;
            } else {
                idx = now;

                if (parseInt(duple / 100) != 0) {
                    count += 3;
                } else if (parseInt(duple / 10) !== 0) {
                    count += 2;
                } else if (duple !== 0) {
                    count++;
                } 
                count += i;
                duple = 0;
            }
            //console.log("count", count, " duple",duple)
        }
        if (parseInt(duple / 100) !== 0) {
            count += 3;
        } else if (parseInt(duple / 10) !== 0) {
            count += 2;
        } else if (duple !== 0) {
            count++;
        } 
        duple = 0;
        //console.log(s,i,count," + ", (strArr.length % i))
        answer = Math.min(answer, count + (strArr.length % i));
    }

    return answer;
}


const input = ["aabbaccc","ababcdcdababcdcd","abcabcdede","abcabcabcabcdededededede","xababcdcdababcdcd"]

for(var i = 0; i < 5; i++){
    console.log(solution(input[i]))
}

//console.log(solution(input[0]))