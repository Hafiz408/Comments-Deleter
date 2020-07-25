#include <iostream>
#include<fstream>
#include<string>
#include<string.h>
using namespace std;

int main(int argc,char* argv[])
{
    ifstream old_file;
    ofstream new_file;
    char file_name[100],address[100]= "C:\\Users\\Hafiz408\\Desktop\\edu.duke\\original\\";
    cout<<"Enter File Name with extension :";
    cin>>file_name;
    strcat(address,file_name);
    old_file.open(address);
    char new_address[100]= "C:\\Users\\Hafiz408\\Desktop\\edu.duke\\comments deleted\\";
    strcat(new_address,file_name);
    new_file.open(new_address);
    string line;
    while(old_file && new_file)
    {
        getline(old_file,line);
        if(line.find("/*")!=string::npos)
        {
            while(1)
            {
                getline(old_file,line);
                if(line.find("*/")!=string::npos)
                {
                    getline(old_file,line);
                    break;
                }
            }
        }
        new_file<<line<<endl;
    }
    old_file.close();
    new_file.close();
    cout << "Comments Deleter program executed successfully" << endl;
    return 0;
}
