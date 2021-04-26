#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    vector<string> strings;
    strings.push_back("12342");
    strings.push_back("12");
    strings.push_back("1");
    strings.push_back("2");
    strings.push_back("234");
    strings.push_back("23466");
    sort(strings.begin(), strings.end());
    for(auto str : strings)
        cout << str << endl;

    return 0;
}