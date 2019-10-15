package com.prumo.portonect.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	/**
	 * Quando estiver em 'testContext' os métodos vão se comportar de forma diferente para satisfazer o teste.
	 * Como esse classe é utilizada por toda a aplicação, deve-se ter o cuidado de desativar o contexto de teste
	 * ao final da execução do mesmo.
	 */
	private static boolean testContext = false;
	
	public static boolean isTestContext() {
		return testContext;
	}

	public static void setTestContext(boolean testContext) {
		PropertiesUtil.testContext = testContext;
	}

//	public static String getEnvVar(String key) {
//		String value = System.getenv(key);
//		return value;
//	}
	
	public static String getVersion() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String versao = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			versao =  prop.getProperty("portonet.versao");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return versao;
		
	}
	
	public static String getEmailServer() {
		
		// Para o contexto de teste retorna um servidor inexistente
		if ( isTestContext() ) {
			return "[SERVIDOR DE TESTE]";
		}
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailServer = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailServer =  prop.getProperty("portonet.email.server");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return emailServer;
		
	}
	
	public static int getEmailPort() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailPort = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailPort =  prop.getProperty("portonet.email.port");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return Integer.parseInt(emailPort);
		
	}
	
	public static String getDBOwner() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String dbowner = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			dbowner =  prop.getProperty("portonet.db.owner");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dbowner;
		
	}
	
	public static String getDBLogPath() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String dblog = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			dblog =  prop.getProperty("portonet.dblog.path");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dblog;
		
	}
	
	public static String getPasta() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String diretorio = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			diretorio =  prop.getProperty("portonet.pasta");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return diretorio;
		
	}
	
	public static String getEmailSender() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailSender = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailSender =  prop.getProperty("portonet.email.sender");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return emailSender;
		
	}
	
	public static String getEmailSenderUser() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailSenderUser = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailSenderUser =  prop.getProperty("portonet.email.sender.user");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return emailSenderUser;
		
	}
	
	
	
	public static String getEmailSenderPass() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailSenderPass = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailSenderPass =  prop.getProperty("portonet.email.sender.pass");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return emailSenderPass;
		
	}
	
	public static String getEmailAutenticar() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String emailSenderPass = "";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			
			input = loader.getResourceAsStream("portonet.properties");
			prop.load(input);
			emailSenderPass =  prop.getProperty("portonet.email.autenticar");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return emailSenderPass;
		
	}
    
    public static String getPathImagem() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String pathImagem = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    pathImagem =  prop.getProperty("portonet.path.imagem");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return pathImagem;

    }

    public static String getUrlPorto() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String url = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    url =  prop.getProperty("portonet.url.porto");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return url;

    } 
            
    public static String getQrCodeExtensao() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String extensao = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    extensao =  prop.getProperty("portonet.qrcode.extensao");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return extensao;

    } 
            
    public static String getQrCodeTamanho() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String tamanho = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    tamanho =  prop.getProperty("portonet.qrcode.tamanho");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return tamanho;

    }
    
    public static String getQrCodePath() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String path = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    path =  prop.getProperty("portonet.qrcode.path");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return path;

    }
    
    public static String getQrCodeHttps() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String https = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    https =  prop.getProperty("portonet.qrcode.https");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return https;

    }
    
    public static String getQrCodeUrl() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String url = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    url =  prop.getProperty("portonet.qrcode.url");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return url;

    }
    
    public static String getTextoEmail() {
		
            Properties prop = new Properties();
            InputStream input = null;
            String texto = "";
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            try {

                    input = loader.getResourceAsStream("portonet.properties");
                    prop.load(input);
                    texto =  prop.getProperty("portonet.email.texto");

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

            return texto;

    }

}
