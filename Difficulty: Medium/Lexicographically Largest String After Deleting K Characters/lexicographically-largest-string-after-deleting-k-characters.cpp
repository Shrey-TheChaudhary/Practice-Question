class Solution {
  public:
    string maxSubseq(string& s, int k) {
        string st;
        for (char c : s) {
            while (k && st.size() && st.back() < c) {
                st.pop_back();
                k--;
            }
            st.push_back(c);
        }
        while (k-- && st.size()) st.pop_back();
        return st.empty() ? "" : st;
    }
};
