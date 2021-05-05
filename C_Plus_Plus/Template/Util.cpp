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
