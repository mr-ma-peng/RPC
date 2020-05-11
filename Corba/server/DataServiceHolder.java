
/**
* DataServiceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2020年5月10日 星期日 下午01时49分12秒 CST
*/

public final class DataServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public DataService value = null;

  public DataServiceHolder ()
  {
  }

  public DataServiceHolder (DataService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DataServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DataServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DataServiceHelper.type ();
  }

}
