hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:proconCoreDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
		dataSource_ds2 {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:ds2;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
	}
	test {
		dataSource {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:proconCoreDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
		dataSource_shopbert {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:shopbertDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
		grails {
			mongo {
				host = '127.0.0.1'
				port = '27017'
				databaseName ='proconCore'
				options {
					autoConnectRetry = true
					connectTimeout = 300
				}
			}
		}
	}
	production {
		dataSource {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:proconCoreDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
		dataSource_shopbert {
			pooled = true
			dbCreate = "update"
			url = "jdbc:h2:mem:shopbertDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			logSql = false
		}
	}
}
