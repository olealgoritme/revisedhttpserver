package no.kristiania.pgr200.jlw;

public class HttpServerParserFactory implements HttpServerParserFactoryInterface{

    public HttpServerRequest request;
    public String httpRequestMethodType;

    public HttpServerParserFactory(HttpServerRequest request){
        this.request = request;
        int delimiterPos = request.getRequestBody().get(0).indexOf(" ");
        try{
            httpRequestMethodType = request.getRequestBody().get(0).substring(0, delimiterPos);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Error retrieving request type.");
        }
    }

    public HttpServerParser createParser(String httpRequestMethodType) {
        switch(httpRequestMethodType){
            case "GET":
                return new HttpServerParserGET(request);
            case "POST":
                return new HttpServerParserPOST(request);
            default:
                throw new IllegalArgumentException("Invalid HTTP method");
       }
    }

    public String getHttpRequestMethodType(){
        return httpRequestMethodType;
    }
}
