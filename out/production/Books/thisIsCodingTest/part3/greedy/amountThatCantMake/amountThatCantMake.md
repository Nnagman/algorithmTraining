## 만들 수 없는 금액

### 그리디 알고리즘 ( 314p, 이것이 코딩테스트다 )
###

#### max_value=가져온 금액들을 합친 값
###

주어진 금액들의 조합으로 만들 수 없는 가장 작은 금액 찾아내는 것이다.<br>
금액들의 정보가 담긴 배열을 정렬한 뒤, 반복문으로 가져온다.<br>
가져온 값은 max_value란 변수에 담는다.<br>
만약 가져온 값이 max_value보다 크다면 반복문을 종료한다.<br>
반복문이 끝났다면 max_value를 반환한다.<br/>