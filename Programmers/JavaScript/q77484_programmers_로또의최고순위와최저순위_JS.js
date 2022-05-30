function solution(lottos, win_nums) {
    let answer = [0,0];
    const grade = [ 6, 6, 5, 4, 3, 2, 1 ];

    let p = 0;
    let c = 0;

    for (var i = 0; i < 6; i++) {
        if (lottos[i] == 0) {
            p++;
        } else {
            for (var j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    c++;
                    break;
                }
            }
        }
    }
    
    answer[0] = grade[p+c];
    answer[1] = grade[c];
    
    return answer;
}

lottos = [ 44, 1, 0, 0, 31, 25 ]
win_nums = [ 31, 10, 45, 1, 6, 19 ]

console.log(solution(lottos, win_nums))