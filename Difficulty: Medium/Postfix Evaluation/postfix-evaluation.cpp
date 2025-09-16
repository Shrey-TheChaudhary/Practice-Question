class Solution {
  public:
    int evaluatePostfix(vector<string>& arr) {
        // code here
        stack<int> s;
        for(auto i: arr){
            if(i=="*" ||i=="+"||i=="-"||i=="/"||i=="^"){
                int last=s.top();
                s.pop();
                int slast=s.top();
                s.pop();
                if(i=="*") s.push(last*slast);
                else if(i=="+") s.push(last+slast);
                else if(i=="-")s.push(slast-last);
                else if(i=="/"){
                    int division=slast/last;
                    int reminder=abs(slast)%abs(last);
                    if(reminder!=0 &&(last*slast)<0){
                        division--;
                    }
                    s.push(division);
                }
                else{
                    int power=(int)pow(slast,last);
                    s.push(power);
                }
            }
            else{
                s.push(stoi(i));
            }
        }
        return s.top();
    }
};