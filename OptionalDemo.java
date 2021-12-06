package com.dnapass.training.java.stream;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		Optional<String> empty = Optional.empty();
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
//previous
		if (name != null) {
			System.out.println(name);
		}
//now
		if (opt.isPresent()) {
			System.out.println(opt);
			System.out.println(opt.get());
		}

		name = "baeldung";
		opt = Optional.ofNullable(name);
		if (opt.isPresent()) {
			System.out.println(opt);
			System.out.println(opt.get());
		}
		name = null;
		opt = Optional.ofNullable(name);
		if (opt.isPresent()) {
			System.out.println(opt);
			System.out.println(opt.get());
			System.out.println(opt.get().length());
		}
		if (name != null)
			System.out.println(name.length());
		opt = Optional.of("baeldung");
		opt.ifPresent(n -> System.out.println(n.length()));
		String nullname = null;
		name = Optional.ofNullable(nullname).orElse("John");
		System.out.println(name);
//supplier
		nullname = null;
		name = Optional.ofNullable(nullname).orElseGet(() -> "John");
		System.out.println(name);
		OptionalDemo optionalDemo = new OptionalDemo();
		String text = "text";
// String defaultText = Optional.ofNullable(text).orElse(optionalDemo::getMyDefault);
		nullname = null;
		name = Optional.of(nullname).orElseThrow(IllegalArgumentException::new);
		opt = Optional.of("baeldung");
		name = opt.get();
		opt = Optional.ofNullable(null);
		name = opt.get();
		optionalDemo.demo();
		name.chars();
	}

	public String getMyDefault() {
		return "John";
	}

	public void demo() {
		Computer computer = newComputer();
		String version = millionDollarBug(computer);
		System.out.println(version);
		version = traditionalNullPointerHandling(computer);
		System.out.println(version);
		Optional<Computer> mayBeComputer = newMayBeComputer();
		version = optionalDemo(mayBeComputer);
		System.out.println(version);
	}

	private static String optionalDemo(Optional<Computer> mayBeComputer) {
		return mayBeComputer.flatMap(Computer::getMayBeSoundCard).flatMap(SoundCard::getMayBeUsb).map(USB::getVersion)
				.orElse("UNKNOWN");
	}

	private static String traditionalNullPointerHandling(Computer computer) {
		String version = "UNKNOWN";
		if (computer != null) {
			SoundCard soundCard = computer.getSoundCard();
			if (soundCard != null) {
				USB usb = soundCard.getUSB();
				if (usb != null) {
					version = usb.getVersion();
				}
			}
		}
		return version;
	}

	private static String millionDollarBug(Computer computer) {
		return computer.getSoundCard().getUSB().getVersion();
	}

	private Optional<Computer> newMayBeComputer() {
		Computer computer = new Computer();
		SoundCard soundCard = new SoundCard();
		USB usb = new USB();
		usb.setVersion("1.0");
		soundCard.setUsb(usb);
		computer.setSoundCard(soundCard);
		Optional<Computer> optionalComputer = Optional.of(computer);
		Optional<SoundCard> mayBeSoundCard = Optional.of(soundCard);
		Optional<USB> mayBeUsb = Optional.of(usb);
		soundCard.setMayBeUsb(mayBeUsb);
		computer.setMayBeSoundCard(mayBeSoundCard);
		return optionalComputer;
	}

	public Computer newComputer() {
		Computer computer = new Computer();
		SoundCard soundCard = new SoundCard();
		USB usb = new USB();
		usb.setVersion("1.0");
		soundCard.setUsb(usb);
		computer.setSoundCard(soundCard);
		return computer;
	}

	public class USB {
		String version = "1.0";

		public void setVersion(String version) {
			this.version = version;
		}

		public String getVersion() {
			return version;
		}
	}

	public class SoundCard {
		USB usb = null;
		Optional<USB> mayBeUsb = null;

		public USB getUSB() {
			return usb;
		}

		public USB getUsb() {
			return usb;
		}

		public void setUsb(USB usb) {
			this.usb = usb;
		}

		public Optional<USB> getMayBeUsb() {
			return mayBeUsb;
		}

		public void setMayBeUsb(Optional<USB> mayBeUsb) {
			this.mayBeUsb = mayBeUsb;
		}

	}

	public class Computer {
		SoundCard soundCard = null;
		Optional<SoundCard> mayBeSoundCard = null;

		public SoundCard getSoundCard() {
			return soundCard;
		}

		public void setSoundCard(SoundCard soundCard) {
			this.soundCard = soundCard;
		}

		public Optional<SoundCard> getMayBeSoundCard() {
			return mayBeSoundCard;
		}

		public void setMayBeSoundCard(Optional<SoundCard> mayBeSoundCard) {
			this.mayBeSoundCard = mayBeSoundCard;
		}
	}

}
