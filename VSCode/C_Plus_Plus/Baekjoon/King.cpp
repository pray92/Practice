#include <iostream>
#include <string>

using namespace std;

void getNextWay(string code, int &x, int &y)
{
  if (code == "R")
  {
    x = 1;
    y = 0;
  }
  else if (code == "L")
  {
    x = -1;
    y = 0;
  }
  else if (code == "B")
  {
    x = 0;
    y = -1;
  }
  else if (code == "T")
  {
    x = 0;
    y = 1;
  }
  else if (code == "RT")
  {
    x = 1;
    y = 1;
  }
  else if (code == "LT")
  {
    x = -1;
    y = 1;
  }
  else if (code == "RB")
  {
    x = 1;
    y = -1;
  }
  else if (code == "LB")
  {
    x = -1;
    y = -1;
  }
}

void getPosition(string code, int &x, int &y)
{
  x = code[0] - 'A' + 1;
  y = code[1] - '0';
}

string getPositionString(int const &x, int const &y)
{
  string ret;
  ret = 'A' + (x - 1);
  ret += '1' + (y - 1);
  return ret;
}

int main()
{
  string curKingCode, curStoneCode;
  int count;
  cin >> curKingCode >> curStoneCode >> count;

  int stoneX, stoneY;
  getPosition(curStoneCode, stoneX, stoneY);
  
  int kingX, kingY;
  getPosition(curKingCode, kingX, kingY);

  for (int i = 0; i < count; ++i)
  {
    string code;
    cin >> code;

    int nX, nY;
    getNextWay(code, nX, nY);
    
    int nextKingX = kingX + nX;
    int nextKingY = kingY + nY;
    if(1 <= nextKingX && nextKingX <= 8
    && 1 <= nextKingY && nextKingY <= 8)
    {
      if(nextKingX == stoneX && nextKingY == stoneY)
      {
        int nextStoneX = stoneX + nX;
        int nextStoneY = stoneY + nY;
        if(1 <= nextStoneX && nextStoneX <= 8
        && 1 <= nextStoneY && nextStoneY <= 8)
        {
          stoneX = nextStoneX;
          stoneY = nextStoneY;

          kingX = nextKingX;
          kingY = nextKingY; 
        }
      }
      else
      {
        kingX = nextKingX;
        kingY = nextKingY; 
      }
    }
  }

  cout << getPositionString(kingX, kingY) << endl;
  cout << getPositionString(stoneX, stoneY) << endl;
}