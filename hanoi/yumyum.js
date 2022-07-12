function solution(n) {
	let answer = [];

	function hanoi(cnt, from, to, mid) {
		if (cnt === 1) return answer.push([from, to]);
		hanoi(cnt - 1, from, mid, to);
		answer.push([from, to]);
		hanoi(cnt - 1, mid, to, from);
	}
	hanoi(n, 1, 3, 2);
	return answer;
}
