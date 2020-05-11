#include "DataService.h"
#include <stdio.h>
int main(int argc,char* argv[]){
	printf("111111111111111111111111");
    try{
 
        CORBA::ORB_var orb = CORBA::ORB_init(argc,argv);
 
        char* IORStr= "IOR:000000000000001449444c3a44617461536572766963653a312e3000000000010000000000000086000102000000000e3139322e3136382e3234352e3100c0b600000031afabcb0000000020ff10f49b00000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";
 
        CORBA::Object_var obj = orb->string_to_object(IORStr);
        if(CORBA::is_nil(obj)){
            printf("Nil Score Reference");
            throw 0;
        }
        DataService_var tm = DataService::_narrow(obj);
        if(CORBA::is_nil(tm)){
            printf("Nil Score Reference");
            throw 0;
        }
        printf("³É¼¨Îª  %f\n ",tm->search("2017013196"));
    }catch(const CORBA::Exception&){
        printf("Exception\n");
        return 1;
    }


	printf("222222222222222222222222222");

    return 0;
}