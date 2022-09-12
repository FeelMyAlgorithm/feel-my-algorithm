var maxArea = function (height) {
  let answer = 0;

  let left = 0;
  let right = height.length - 1;

  while (left < right) {
    let h = Math.min(height[left], height[right]);
    answer = Math.max(answer, h * (right - left));
    if (height[left] < height[right]) {
      left++;
    } else {
      right--;
    }
  }

  return answer;
};
