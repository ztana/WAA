task					min				max				actual				status
selectOneMenu			60				80				80					done
bean for menu			30				60				40					done
detail view				30				60				30					done
bean for detail			60				80				80					almost

I got a problem. I can't forward to next page (shopping.xhtml in my case). first I just use return string
in my valueChangeMethod method, it's not work so I searched google, I tried FacesContext.getCurrentInstance().getExternalContext().dispatch("shopping.xhtml");
 but still not work. It still return me the same page.