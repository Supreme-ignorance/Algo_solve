# [Gold I] 완전그래프의 최소 스패닝 트리 - 20390 

[문제 링크](https://www.acmicpc.net/problem/20390) 

### 성능 요약

메모리: 16356 KB, 시간: 5816 ms

### 분류

그래프 이론(graphs), 최소 스패닝 트리(mst)

### 문제 설명

<p>0 부터 <em>N</em> - 1 까지 번호가 부여된 <em>N</em> 개의 정점을 가진 완전그래프가 있다.</p>

<p>각 정점 <em>i</em> 는 어떤 값 <em>X<sub>i</sub></em> 를 가지고 있다.</p>

<p>번호의 크기 관계가 <em>i</em>  < <em>j</em>  를 만족하는 두 정점 <em>i</em> 와 <em>j</em> 사이를 연결하는 양방향 간선의 가중치 <em>dist</em>(<em>i</em>, <em>j</em>) 는 다음과 같이 계산된다.</p>

<p style="text-align: center;"><em>dist</em>(<em>i</em>, <em>j</em>) = ((<em>X<sub>i</sub></em>  × <em>A</em> + <em>X<sub>j</sub></em>  × <em>B</em>) % <em>C</em>) ^ <em>D</em></p>

<p>여기서 <em>A</em>, <em>B</em>, <em>C</em>, <em>D</em> 는 상수이고, % 는 나눗셈의 나머지 연산, ^ 는 bitwise XOR 연산을 의미한다.</p>

<p>주어진 그래프의 최소 신장 트리 (MST) 의 가중치를 구해보자.</p>

### 입력 

 <p>첫 번째 줄에는 정점의 개수 <em>N</em> 이 주어진다.</p>

<p>두 번째 줄에는 4 개의 정수 <em>A</em>, <em>B</em>, <em>C</em>, <em>D</em> 가 차례대로 주어진다.</p>

<p>세 번째 줄에는 <em>N</em> 개의 정수가 주어진다. 이는 <em>X<sub>i</sub></em> 가 0 번 정점부터 시작해서 <em>N</em>-1 번까지 순서대로 주어진 것이다.</p>

<p>입력으로 주어지는 모든 수는 제약사항의 범위를 만족하는 정수이며, 각 수는 공백으로 구분된다.</p>

### 출력 

 <p>최소 신장 트리의 가중치를 출력한다.</p>

