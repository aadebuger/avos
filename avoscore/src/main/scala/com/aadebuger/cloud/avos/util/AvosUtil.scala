package com.aadebuger.cloud.avos.util

/**
 * Created with IntelliJ IDEA.
 * User: aadebuger
 * Date: 13-9-4
 * Time: 上午11:48
 * To change this template use File | Settings | File Templates.
 */
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

class AvosUtil {

}
object AvosUtil {
  var mymongo:Mongo =_;
  var host="localhost";
  var dbname="avos";
  def getCollection( collectionname:String)=
  {
    if ( mymongo==null )
      mymongo=new Mongo(host);

    var db=mymongo.getDB(dbname);

    var col=db.getCollection(collectionname);
       col
  }
}
