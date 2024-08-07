class Solution {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String[] ones={"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
        String[] tens={"","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        String ans="";

        if(num>=1000000000){
            int temp=num/1000000000;
            ans+=ones[temp]+"Billion ";
            num%=1000000000;
        }
        if(num>=100000000){
            int temp=num/1000000;
                if(temp%100>=0){
                    ans+=ones[temp/100]+"Hundred ";
                }
                temp%=100;
                int count=0;
                if(temp>=20){
                    ans+=tens[temp/10-1];
                }
                if(temp<20){
                    ans+=ones[temp];
                    count=1;
                }
                temp%=10;
                if(count==0){
                    if(temp>0){
                        ans+=ones[temp];
                    }
                }
                ans+="Million ";
                num%=1000000;
        }
        if(num>=10000000){
            int temp=num/1000000;
            if(temp>=20){
                ans+=tens[temp/10-1];
            }
            temp%=100;
            int count=0;
                if(temp<20){
                    ans+=ones[temp];
                    count=1;
                }
                temp%=10;
                if(count==0){
                    if(temp>0){
                        ans+=ones[temp];
                    }
                }
            ans+="Million ";
             num%=1000000;
        }
        if(num>=1000000){
            int temp=num/1000000;
            ans+=ones[temp]+"Million ";
            num%=1000000;
        }
        if(num>=100000){
                int temp=num/1000;
                if(temp>=100){
                    ans+=ones[temp/100]+"Hundred ";
                }
                temp%=100;
                if(temp>=20){
                    ans+=tens[temp/10-1];
                }
                int count=0;
                if(temp<20){
                    ans+=ones[temp];
                    count=1;
                }
                temp%=10;
                if(count==0){
                    if(temp>0){
                        ans+=ones[temp];
                    }
                }
                ans+="Thousand ";
                num%=1000;
            }
        if(num>=10000){
                int temp=num/1000;
                if(temp>=20){
                    ans+=tens[temp/10-1];
                    temp%=10;
                }
                if(temp<20){
                    ans+=ones[temp];
                }
                ans+="Thousand ";
                num%=1000;
            }
        if(num>=1000){
            ans+=ones[num/1000]+"Thousand ";
            num%=1000;
        }
        if(num>=100){
            ans+=ones[num/100]+"Hundred ";
            num%=100;
        }
        if(num>=20){
            ans+=tens[num/10-1];
            num%=10;
        }
        if(num>0 && num<20){
            ans+=ones[num];
        }
        return ans.trim();
    }
}