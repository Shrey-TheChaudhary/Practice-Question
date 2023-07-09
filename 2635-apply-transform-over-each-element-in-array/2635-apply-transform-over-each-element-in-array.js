/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const ans = new Array(arr.length);
    for( let i=0;i<arr.length; ++i)
        ans[i] = fn(arr[i],i)
    
    return ans;
};