#include <iostream>
 using namespace std; 
 class Heap { 
     public: int* nodes; int size; int capacity; 
     public: 
     Heap(int defaultCapacity) { this->capacity = defaultCapacity; this->size = 0; this->nodes = new int[this->capacity]; } 
     ~Heap() { delete this->nodes; } 
     void add(int data) { // 예외 발생( 크기 재할당을 해주어도 된다 ) 
        if (this->size >= this->capacity) 
        throw this->size; 
        // 배열로 구현 시 인덱스는 1부터 시작 
        this->nodes[++this->size] = data; 
        // 순위 조정 
        int i = this->size; 
        while (i > 1 && this->nodes[i] < this->nodes[i / 2]) { 
            swap(i, i / 2); i /= 2; 
        } 
    } 
    int pop() { 
        // 예외 발생 
        if (this->size == 0) 
            throw this->size; 
        // 첫번째 원소 반환 후 마지막 원소를 첫번째에 대입 
        int ret = this->nodes[1]; 
        this->nodes[1] = this->nodes[this->size--]; 
        // 조정 
        int i = 1; 
        while (this->size >= (i * 2 + 1)) { 
            if (this->nodes[i] > this->nodes[i * 2]) { 
                swap(i, i * 2); 
                i *= 2; 
            } 
            else if (this->nodes[i] > this->nodes[i * 2 + 1]) { 
                swap(i, i * 2 + 1); 
                i = i * 2 + 1; 
            } 
            else { 
                break; 
            } 
        } 
        return ret; 
    } 
    void printAll() { 
        if (this->size == 0) { cout << "This heap has no element." << endl; return; } cout << "size : " << this->size << endl; for (int i = 1; i <= this->size; i++) { cout << this->nodes[i] << " "; } cout << endl; } private: void swap(int idx1, int idx2) { int tmp = this->nodes[idx1]; this->nodes[idx1] = this->nodes[idx2]; this->nodes[idx2] = tmp; } };

int main()
{
    Heap h(1024);
    h.add(15);
    h.add(3);
    h.add(2);
    h.add(7);
    h.add(9);
    h.add(12);
    h.add(16);

    
    while(h.size > 0)
        cout << h.pop() << endl;
    //h.printAll();

    return 0;
}