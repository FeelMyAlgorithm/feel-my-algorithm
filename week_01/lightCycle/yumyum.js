function solution(grid) {
	let answer = [];

	const directions = [
		[-1, 0],
		[0, 1],
		[1, 0],
		[0, -1],
	];
	const rowLen = grid.length;
	const colLen = grid[0].length;
	let visited = Array.from({ length: rowLen }, () =>
		Array.from({ length: colLen }, () => [false, false, false, false])
	);

	function handleIndex(row, col) {
		let newRow = row === -1 ? rowLen - 1 : row === rowLen ? 0 : row;
		let newCol = col === -1 ? colLen - 1 : col === colLen ? 0 : col;
		return [newRow, newCol];
	}

	let stack = [];
	for (let i = 0; i < rowLen; i++) {
		for (let j = 0; j < colLen; j++) {
			for (let d = 0; d < 4; d++) {
				stack.push([0, d, [i, j]]);
			}
		}
	}
	while (stack.length !== 0) {
		const [cnt, lastIdx, cur] = stack.pop();
		if (!visited[cur[0]][cur[1]][lastIdx]) {
			visited[cur[0]][cur[1]][lastIdx] = true;
		} else {
			if (cnt) answer.push(cnt);
			continue;
		}
		if (grid[cur[0]][cur[1]] === "S") {
			// 직진
			let newNode = handleIndex(
				cur[0] + directions[lastIdx][0],
				cur[1] + directions[lastIdx][1]
			);
			stack.push([cnt + 1, lastIdx, newNode]);
		} else if (grid[cur[0]][cur[1]] === "L") {
			// 좌회전
			let newDirectionIndex = lastIdx === 0 ? 3 : lastIdx - 1;
			let newNode = handleIndex(
				cur[0] + directions[newDirectionIndex][0],
				cur[1] + directions[newDirectionIndex][1]
			);
			stack.push([cnt + 1, newDirectionIndex, newNode]);
		} else {
			//우회전
			let newDirectionIndex = lastIdx === 3 ? 0 : lastIdx + 1;
			let newNode = handleIndex(
				cur[0] + directions[newDirectionIndex][0],
				cur[1] + directions[newDirectionIndex][1]
			);
			stack.push([cnt + 1, newDirectionIndex, newNode]);
		}
	}

	return answer.sort((a, b) => a - b);
}
