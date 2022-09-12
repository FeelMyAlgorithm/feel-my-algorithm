var lengthOfLongestSubstring = function (s) {
  let result = 0;
  let set = new Set(s.split("")); // 사용된 문자 빼냄

  let lastIndex = {};
  set.forEach((el) => (lastIndex[el] = -1)); // index를 -1로 초기화

  let i = 0;
  for (let j = 0; j < s.length; j++) {
    i = Math.max(i, lastIndex[s[j]] + 1); // i는 i보다 지금 보고있는 문자의 마지막 index 저장보다 1크면 업데이트
    result = Math.max(result, j - i + 1); // 결과는 지금 보고있는 인덱스에서 i와의 거리가 크면 업데이트
    lastIndex[s[j]] = j; //지금 보고있는 문자의 lastindex를 갱신
  }

  return result;
};
