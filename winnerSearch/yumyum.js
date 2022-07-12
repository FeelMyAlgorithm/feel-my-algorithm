function solution(infos, querys) {
	const data = new Map();
	infos.forEach((item) => {
		const info = item.split(" ");
		const score = parseInt(info.pop());

		let key = info.join("");
		data.set(key, data.has(key) ? [...data.get(key), score] : [score]);
	});

	for (let [key, value] of data) {
		data.set(
			key,
			value.sort((a, b) => a - b)
		);
	}

	return querys.map((e) => {
		const queries = e.split(/ and | |-/i).filter((e) => e);
		return search(data, queries);
	});
}

const search = (data, queries) => {
	const score = queries.pop();
	return Array.from(data.keys())
		.filter((key) => queries.every((v) => key.includes(v)))
		.reduce(
			(acc, cur) =>
				acc +
				data.get(cur).slice(binarySearch(data.get(cur), score)).length,
			0
		);
};

const binarySearch = (arr, target) => {
	let left = 0;
	let right = arr.length;
	while (left < right) {
		const mid = Math.floor((left + right) / 2);

		if (arr[mid] >= target) right = mid;
		else left = mid + 1;
	}

	return left;
};
