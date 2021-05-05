#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>

#include <sstream>

using namespace std;

namespace
{
    vector<string> Split(string input, char delimiter)
    {
        vector<string> ret;
        stringstream ss(input);
        string tmp;

        while(getline(ss, tmp, delimiter))
            ret.push_back(tmp);
        return ret;
    }


    enum ActionType
    {
        NONE = 0,
        ENTER,
        LEAVE,
        CHANGE,
    };

    void ParseRecord(string record, ActionType& actionType, string& uid, string& nickName)
    {
        const vector<string>& parsed = Split(record, ' ');

        if(parsed[0] == "Enter")
        {
            actionType = ENTER;
            uid = parsed[1];
            nickName = parsed[2];
        }
        else if(parsed[0] == "Leave")
        {
            actionType = LEAVE;
            uid = parsed[1];
        }
        else if(parsed[0] == "Change")
        {
            actionType = CHANGE;
            uid = parsed[1];
            nickName = parsed[2];
        }
    }
}

vector<string> solution(vector<string> records) 
{
    map<string /* UID */, string /* NickName */> idMap;
    vector<pair<string /* UID */, ActionType/* Enter/Leave */>> records2;
    for(const string& record : records)
    {
        ActionType actionType = NONE;
        string uid, nickName;
        ParseRecord(record, actionType, uid, nickName);
        if(actionType == NONE)
            continue;

        switch(actionType)
        {
            case ENTER:
            {
                idMap[uid] = nickName;
                records2.push_back(make_pair(uid, ENTER));
            } break;
            case LEAVE:
            {
                records2.push_back(make_pair(uid, LEAVE));
            } break;
            case CHANGE:
            {
                idMap[uid] = nickName;
            } break;
        }
    }

    vector<string> answer;
    for(const pair<string, ActionType>& record : records2)
    {
        string res = idMap[record.first] + "님이 ";
        res += (record.second == ENTER) ? "들어왔습니다." : "나갔습니다.";

        answer.push_back(res);
    }

    return answer;
}

int main()
{
    const vector<string>& sol = solution({  "Enter uid1234 Muzi", 
                                            "Enter uid4567 Prodo",
                                            "Leave uid1234",
                                            "Enter uid1234 Prodo",
                                            "Change uid4567 Ryan" });
    for(const string& s : sol)
        cout << s << endl;

    return 0;
}