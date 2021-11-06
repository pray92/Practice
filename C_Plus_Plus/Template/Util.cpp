#include "Util.h"

#include <sstream>

vector<string> Split(string input, char delimiter)
{
    vector<string> ret;
    stringstream ss(input);
    string tmpString;

    while(getline(ss, tmpString, delimiter))
        ret.push_back(tmpString);
    return ret;
}


int main()
{
    char* cs = "SMS 010-1234-5678";
    string str = cs;
    auto ret = Split(str, ' ');
    cout << ret[0] << ret[1] << endl;

    return 0; 
}