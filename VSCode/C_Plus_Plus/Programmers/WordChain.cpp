#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

// 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
// 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
// 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
// 이전에 등장했던 단어는 사용할 수 없습니다. 
vector<int> solution(int n, vector<string> words) 
{
    vector<int> answer(2, 0);
    if(words.size() <= 1)
        return answer;
    
    set<string> mentioned;
    string prevWord = words[0];
    mentioned.insert(prevWord);
    for(size_t nWordIndex = 1; nWordIndex < words.size(); ++nWordIndex)
    {
        const string& word = words[nWordIndex];
        pair<set<string>::iterator, bool> res = mentioned.insert(word);
        if(!res.second || *prevWord.rbegin() != *word.begin())
        {
            answer[0] = static_cast<int>(nWordIndex % n) + 1;
            answer[1] = static_cast<int>(nWordIndex / n) + 1;
            break;
        }
        prevWord = word;
    }

    return answer;
}

int main()
{
    cout << "Hello world" << endl;

    // vector<int> ans = solution(3, {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    // cout << "[" << ans[0] << ", " << ans[1] << "]" << endl;
    // ans = solution(5, {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
    // cout << "[" << ans[0] << ", " << ans[1] << "]" << endl;
    // ans = solution(2, {"hello", "one", "even", "never", "now", "world", "draw"});
    // cout << "[" << ans[0] << ", " << ans[1] << "]" << endl;


    return 0;
}