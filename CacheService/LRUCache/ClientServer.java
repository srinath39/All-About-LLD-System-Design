package CacheService.LRUCache;

public class ClientServer<K,V>{
    private ICache<K,V> cacheService;

    public ClientServer(ICache<K,V> cacheService){
        this.cacheService=cacheService;
    }

    public ICache<K,V> getCacheService(){
        return cacheService;
    }

    public static void main(String[] args){
        ClientServer<Integer,String> clientServer=new ClientServer<>(new LRUCache<Integer,String>(3));

        clientServer.getCacheService().put(1,"aaa");
        clientServer.getCacheService().put(2,"bbb");
        clientServer.getCacheService().put(3,"sss");
        clientServer.getCacheService().put(2,"yyy");
        clientServer.getCacheService().put(1,"bbb");
        clientServer.getCacheService().put(4,"ccc");

    }
}