package com.java.preparation.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.preparation.exception.CustomException;
import com.java.preparation.service.AnagramService;
import com.java.preparation.service.ArrayProduct;
import com.java.preparation.service.BlockingQueueService;
import com.java.preparation.service.CharCountService;
import com.java.preparation.service.ComparisionService;
import com.java.preparation.service.CountDownLatchService;
import com.java.preparation.service.CyclicBarrierService;
import com.java.preparation.service.DeadLockService;
import com.java.preparation.service.DeltaService;
import com.java.preparation.service.ExcelColumnTitle;
import com.java.preparation.service.ExceptionService;
import com.java.preparation.service.FactoryService;
import com.java.preparation.service.FilesService;
import com.java.preparation.service.FutureTaskService;
import com.java.preparation.service.HotelService;
import com.java.preparation.service.JavaEight;
import com.java.preparation.service.LinkedList;
import com.java.preparation.service.MeandringArrayService;
import com.java.preparation.service.MsTestnig;
import com.java.preparation.service.OverloadingService;
import com.java.preparation.service.OverridingService;
import com.java.preparation.service.PolygonService;
import com.java.preparation.service.SemaphoreService;
import com.java.preparation.service.SerialisationService;
import com.java.preparation.service.SingletonService;
import com.java.preparation.service.SumFinderService;
import com.java.preparation.service.WaitNotifyService;

@Controller
public class TestController {

	@Resource(name="exceptionService")
	private ExceptionService eService;
	
	@Resource(name="fileService")
	private FilesService fService;
	
	@Resource(name="comparisionService")
	private ComparisionService sortingService;
	
	@Resource(name="singletonService")
	private SingletonService singletonService;
	
	@Resource(name="factoryService")
	private FactoryService factoryService;
	
	@Resource(name="serialisationService")
	private SerialisationService serialisationService;
	
	@Resource(name="overloadingService")
	private OverloadingService overloadingService;
	
	@Resource(name="overridingService")
	private OverridingService overridingService;
	
	@Resource(name="meandringArrayService")
	private MeandringArrayService meandringArrayService;
	
	@Resource(name="hotelService")
	private HotelService hotelService;
	
	@Resource(name="sumFinderService")
	private SumFinderService sumFinderService;
	
	@Resource(name="polygonService")
	private PolygonService polygonService;
	
	@Resource(name="deltaService")
	private DeltaService deltaService;
	
	@Resource(name="anagramService")
	private AnagramService anagramService;
	
	@Resource(name="charCountService")
	private CharCountService charCountService;
	
	@Resource(name="semaphoreService")
	private SemaphoreService semaphoreService;
	
	@Resource(name="cyclicBarrierService")
	private CyclicBarrierService cyclicBarrierService; 
	
	@Resource(name="countDownLatchService")
	private CountDownLatchService countDownLatchService;
	
	@Resource(name="blockingQueueService")
	private BlockingQueueService blockingQueueService;
	
	@Resource(name="futureTaskService")
	private FutureTaskService futureTaskService;
	
	@Resource(name="deadLockService")
	private DeadLockService deadLockService;
	
	@Resource(name="waitNotifyService")
	private WaitNotifyService waitNotifyService;
	
	@Resource(name="linkedListRotation")
	private LinkedList linkedListRotationService;
	
	@Resource(name="arrayProduct")
	private ArrayProduct arrayProductService;
	
	@Resource(name="excelService")
	private ExcelColumnTitle excelColumnTitle;

	@Resource(name="javaEight")
	private JavaEight javaEightService;
	
	@Resource(name="msTestnig")
	private MsTestnig msTestnig;
	
	private Logger logger = Logger.getLogger(ExceptionService.class);
	
	@RequestMapping(value="/exception/{methodName}")
	public void testException(@PathVariable("methodName") String methodName) {
		try {
			if("method1".equalsIgnoreCase(methodName)) {
				eService.testExceptionMetod1();
			}
			if("method2".equalsIgnoreCase(methodName)) {
				eService.testExceptionMetod2();
			}
			if("method3".equalsIgnoreCase(methodName)) {
				eService.testExceptionMetod3();
			}
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/fileServiceTest")
	public void FileTest() {
		try {
			fService.readAndWriteFile();
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/sorting/{methodName}")
	public void sorting(@PathVariable("methodName") String methodName) {
		try {
			if("c1".equalsIgnoreCase(methodName)) {
				sortingService.Comparable1();
			}
			if("c2".equalsIgnoreCase(methodName)) {
				sortingService.Comparator1();
			}
			if("c3".equalsIgnoreCase(methodName)) {
				sortingService.Comparator2();
			}
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/singleton/{methodName}")
	public void singleton(@PathVariable("methodName") String methodName) {
		try {
			if("doubleLock".equalsIgnoreCase(methodName)) {
				singletonService.testSingletonDoubleLockInstance();;
			}
			else if("enum".equalsIgnoreCase(methodName)) {
				singletonService.testSingletonEnumInstance();
			}
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/factory/{methodName}")
	public void factory(@PathVariable("methodName") String methodName) {
		try {
			factoryService.testShape(methodName);
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/serialisation")
	public void serialisation() {
		try {
			serialisationService.writeToFile();
			serialisationService.readFromFile();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/overloading")
	public void overloading() {
		try {
			overloadingService.area(4);
			overloadingService.area(4,5);
			overloadingService.area("Circle");
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/overriding")
	public void overriding() {
		try {
			overridingService.testOverriding();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/meandering")
	public void meandering() {
		try {
			meandringArrayService.sorting();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/hotel")
	public void hotel() {
		try {
			hotelService.hotelRanking();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/sumFinder")
	public void sumFinder() {
		try {
			sumFinderService.findSumExists();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/polygon")
	public void polygon() {
		try {
			polygonService.findShapeCount();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/delta")
	public void delta() {
		try {
			deltaService.deltaList();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/anagram")
	public void anagram() {
		try {
			anagramService.checkAnagram();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/charCount")
	public void charCount() {
		try {
			charCountService.characterCount();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/semaphore")
	public void semaphore() {
		try {
			semaphoreService.testSemaphore();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/cyclicBarrier")
	public void cyclicBarrier() {
		try {
			cyclicBarrierService.testCyclicbarrier();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/countDownLatch")
	public void countDownLatch() {
		try {
			countDownLatchService.testCountDownLatch();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/blockingQueue")
	public void blockingQueue() {
		try {
			blockingQueueService.testBlocking();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/future")
	public void future() {
		try {
			futureTaskService.testAdditionTime();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/deadLock")
	public void deadLock() {
		try {
			deadLockService.testDeadLock();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/waitNotify")
	public void waitNotify() {
		try {
			waitNotifyService.testWaitNotify();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/arrayProduct")
	public void arrayProduct() {
		try {
			arrayProductService.arrayProduct();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/linkedListRotation")
	public void linkedListRotation() {
		try {
			linkedListRotationService.rotation();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/javaEight")
	public void javaEight() {
		try {
			javaEightService.testJava8Features();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/msTesting")
	public void msTesting() {
		try {
			msTestnig.startMstesting();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/excelColumn")
	public void excelColumn() {
		try {
			excelColumnTitle.excelColumn();
			
		} catch (CustomException e) {
			logger.error("Eror in Controller ::"+ e.getStackTrace());
			e.printStackTrace();
		}
		
	}
}
