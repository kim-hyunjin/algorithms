/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// chat gpt 풀이
class Solution {
public:
  TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
    // LCA를 찾기 위해 현재 노드를 root로 시작
    while (root != nullptr) {
      // p와 q가 모두 현재 노드보다 작으면, 왼쪽 서브트리로 이동
      if (p->val < root->val && q->val < root->val) {
        root = root->left;
      }
      // p와 q가 모두 현재 노드보다 크면, 오른쪽 서브트리로 이동
      else if (p->val > root->val && q->val > root->val) {
        root = root->right;
      }
      // 그렇지 않다면 현재 노드가 LCA임
      else {
        return root;
      }
    }
    return nullptr; // 트리가 비어있다면 nullptr 반환
  }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution2 {
public:
  TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
    if ((root->val > p->val) && (root->val > q->val)) {
      return lowestCommonAncestor(root->left, p, q);
    }
    if ((root->val < p->val) && (root->val < q->val)) {
      return lowestCommonAncestor(root->right, p, q);
    }
    return root;
  }
};