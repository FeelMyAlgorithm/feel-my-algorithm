var wiggleMaxLength = function (nums) {
  let len = nums.length;
  if (len === 0) return 0;

  let up = Array.from({ length: len }, () => 1); // +로 끝나는 제일 긴 wiggle subsequnce의 길이
  let down = Array.from({ length: len }, () => 1); // -로끝나는 제일 긴 wiggle subsequence의 길이

  for (let i = 1; i < len; ++i) {
    for (let j = 0; j < i; ++j) {
      if (nums[j] < nums[i]) {
        // i와 j번째의 nums를 비교해서 i가 크면 up을 업데이트
        up[i] = Math.max(up[i], down[j] + 1);
      } else if (nums[j] > nums[i]) {
        down[i] = Math.max(down[i], up[j] + 1); // 그 반대면 down을 업데이트
      }
    }
  }
  return Math.max(down[len - 1], up[len - 1]);
};

// 답이 되는 경우에는 두가지 경우가 발생할 수 있음
// a,b를 비교했을 때 b가 더 큰 경우와 더 작은 경우
// b를 1부터 마지막까지 b보다 적은 인덱스를 a로 두면서 반복.
// 비교해가면서 up인 경우 이전의 down에서 1을 더한 것과 기존 up을 비교
// down인 경우 이전의 up에서 1을 더한 것과 기존 down을 비교
