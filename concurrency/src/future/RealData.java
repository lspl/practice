package future;

/**
 ReadData实现Data接口的原因：
    Main中返回的result是 data.getRequest, 此处的data对象为继承了Data接口的FutureData,
 也就是实际上result是FutureData.getRequest的返回结果。而FutureData.getRequest的返回值
 为RealData.getRequest()的结果
 */
public class RealData implements Data{

	private String result ;
	
	public RealData (String queryStr){
		System.out.println(System.currentTimeMillis() + ", 根据" + queryStr + "进行查询，这是一个很耗时的操作..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + ", 操作完毕，获取结果");
		result = System.currentTimeMillis() + ", 查询结果";
	}
	
	@Override
	public String getResult() {
		return result;
	}

}
