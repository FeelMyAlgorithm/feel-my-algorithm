/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function (root) {
  function findWrongNodes(cur) {
    let leftWrong;
    let rightWrong;

    isValid(cur.val, cur.left, "left", leftWrong);
    isValid(cur.val, cur.right, "right", rightWrong);

    if (leftWrong && rightWrong) {
      swap(leftWrong, rightWrong);
      return;
    } else if (leftWrong) {
      swap(leftWrong, cur);
      return;
    } else if (rightWrong) {
      swap(rightWrong, cur);
      return;
    } else {
      if (cur.left) findWrongNodes(cur.left);
      if (cur.right) findWrongNodes(cur.right);
    }

    function isValid(check, cur, direction) {
      if (!cur) return;
      if (direction == "right" && check > cur.val) {
        if (rightWrong) {
          rightWrong =
            Math.abs(cur.val - check) > Math.abs(rightWrong.val - check)
              ? cur
              : rightWrong;
        } else {
          rightWrong = cur;
        }
      }
      if (direction == "left" && check < cur.val) {
        if (leftWrong) {
          leftWrong =
            Math.abs(cur.val - check) > Math.abs(leftWrong.val - check)
              ? cur
              : leftWrong;
        } else {
          leftWrong = cur;
        }
      }
      isValid(check, cur.left, direction);
      isValid(check, cur.right, direction);
    }
  }
  findWrongNodes(root);
};

function swap(a, b) {
  console.log(a, b);
  let tmp = a.val;
  a.val = b.val;
  b.val = tmp;
}
