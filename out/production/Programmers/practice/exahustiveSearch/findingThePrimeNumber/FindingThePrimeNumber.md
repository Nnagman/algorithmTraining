# 소수찾기 - 해시

### https://programmers.co.kr/learn/courses/30/lessons/42839 - 문제 링크

이 문제는 배열과 해시셋 이용해서 푸는 문제다.

### 완전탐색으로 풀기
1. 숫자조합을 저장할 HashSet을 선언합니다. ( set ) 
2. set에 숫자 조합을 저장하기 위해서 숫자문자열의 크기 만큼 for문을 돌며 재귀함수를 불러옵니다.
3. set에 모든 조합의 숫자가 저장된 뒤 set에 저장된 원소들을 하나씩 꺼내 소수인지 확인합니다.
4. 소수가 맞다면 정답으로 반환 할 변수에 값을 1씩 증감 시킨 뒤 반환합니다.

이번 문제는 숫자 문자열을 하나씩 나눈 뒤 조합하여 모든 경우의 수의 숫자들을 구하는 것부터 시작합니다.<br/>
그러기 위해선 완전탐색이 필요한데, 재귀함수를 사용하여 모든 조합의 수를 찾습니다.<br/>
조합된 숫자들 중에서 소수를 찾아야 하는데, 소수를 찾기 위해서 사용된 것은 에라토테네스의 체 방법입니다.<br/>
링크: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes<br/>
에스토라테네스의 체 방법에 따르면 소수를 찾기 위해선 해당 숫자의 제곱근까지만 나눠보면 됩니다. <br/>
그럼 모든 조합된 숫자들이 소수인지 검사하기 위해 제곱근까지만 for문으로 검사합니다. 그리고 나온 결과를 정답으로 반환합니다.