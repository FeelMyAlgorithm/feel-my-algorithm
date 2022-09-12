function solution(s) {
  let answer = [];
  let has = {};
  let sets = s.split("},").map((set) =>
    set
      .replace(/{|}/g, "")
      .split(",")
      .map((el) => Number(el))
  );

  sets.sort((a, b) => a.length - b.length);
  sets.forEach((set) => {
    set.forEach((el) => {
      if (!has[el]) {
        has[el] = true;
        answer.push(el);
      }
    });
  });

  return answer;
}
